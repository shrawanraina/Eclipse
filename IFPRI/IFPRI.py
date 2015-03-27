'''
#    Author:        Shrawan Raina
#    Date:          10/26/2014
#    Email:         shrawan@umd.edu
#    Description:   Script to read a csv file containing LastName, FirstName and E-mail of researchers and the call
#                   ORCiD API to register these users and generate an output csv that contains the unique ORCiD (ID) for each user.
#                   This project is part of the Capstone coursework (INFM737) submitted by Shrawan Raina for Masters in Information Management
#                   (MIM) at iSchool in University of Maryland, College Park.
#                   The project is sponsored by IFPRI - International Food Policy and Research Institute
'''
#Python modules required for the script
from xml.etree import ElementTree as ET    #to generate an xml for each user
from xml.dom import minidom    #to prettify the xml and save in the local computer
import sys
import csv    #to read csv files
import subprocess    #to run Curl command for each user
import re    #for processing Curl response
import StringIO

#Parent Class
class ifpri:
    #Initializing variables
    def __init__(self):
        self.csvfile = open(sys.argv[1]) #sys.argv[1] is the input csv argument passed when calling the script
        self.headers = None
        self.csvInput = []
        self.fileList = {}
        self.resultList = []
        self.get_url = 'https://api.sandbox.orcid.org/v1.1/orcid-profile'
        self.access_token = '9717cc69-270a-4d7e-8bff-9b3f018b72db' #--DO NOT SHARE-- ORCiD Sandbox Access Token for IFPRI
        self.token_type = 'Bearer'
        self.refresh_token = 'b72398eb-627e-451d-945f-1b07dcab2d42'
        self.xmlLocation = '/home/shrawan/Pycharm/IFPRI/' #location where the xml files are stored. --THIS NEED TO BE CHANGED WHEN RUNNING SCRIPT ON A DIFFERENT MACHINE

    #Method to read the input csv
    '''
    #    TO NOTE: The method reads the csv and looks for 'LastName', 'FirstName' and 'E-mail' in the first row of the csv and reads these columns only.
    #    Please make sure that every input csv has these correct headers (Lastname, FirstName, E-mail).
    '''
    def readCSV(self):
        self.desired_columns = ('LastName', 'FirstName', 'E-mail')
        self.reader = csv.reader(self.csvfile)
        for line in self.reader:
            if not self.headers:
                self.headers = []
                for i,col in enumerate(line):
                    if col in self.desired_columns:
                        self.headers.append(i)
            else:
                self.csvInput.append(tuple(line[i] for i in self.headers))
        return self.csvInput #csvInput is a list containing detail of each researcher

    #Method to create xml from the csvList
    '''
    TO NOTE: To change the XML message version in future, please edit message.text values in this method.
    '''
    def createXML(self, csvInput):
        for element in csvInput:
            if element[0] is not '' and element[1] is not '' and element[2] is not '':
                root = ET.Element('orcid-message')
                root.set('xmlns:xsi', 'http://www.w3.org/2001/XMLSchema-instance')
                root.set('xsi:schemaLocation', 'http://www.orcid.org/ns/orcid http://orcid.github.com/ORCID-Parent/schemas/orcid-message/1.0.7/orcid-message-1.0.7.xsd')
                root.set('xmlns', 'http://www.orcid.org/ns/orcid')
                message = ET.SubElement(root, 'message-version')
                message.text = "1.1"
                profile = ET.SubElement(root, 'orcid-profile')
                bio = ET.SubElement(profile, 'orcid-bio')
                pdetails = ET.SubElement(bio, 'personal-details')
                cdetails = ET.SubElement(bio, 'contact-details')
                fname = ET.SubElement(pdetails, 'given-names')
                fname.text = element[1]
                lname = ET.SubElement(pdetails, 'family-name')
                lname.text = element[0]
                email = ET.SubElement(cdetails, 'email')
                email.set('primary', 'true')
                email.text = element[2]
                xmlStr =  ET.tostring(root)
                tree = ET.ElementTree(root)
                xmlPrettyObj = minidom.parseString(xmlStr)
                xmlPrettyObj.writexml(open(element[1]+element[0]+".xml", "w"),newl='\n', encoding = "UTF-8")
                if not self.fileList.has_key(element[1]+element[0]+".xml"):
                    self.fileList[element[1]+element[0]+".xml"] = element
        return self.fileList

    #Method to run Curl command for each XML
    def curlORCiD(self, filelist):
        for key,value in filelist.iteritems():
            curlCmd = 'curl ' \
                      '-H "Accept: application/xml" ' \
                      '-H "Content-Type: application/vdc.orcid+xml" ' \
                      '-H "Authorization: Bearer ' + self.access_token +'" ' \
                      '"' + self.get_url +'" ' \
                      '-X POST ' \
                      '-d "' + '@' +self.xmlLocation + key + '" ' \
                      '-L -i'
            runCurl = subprocess.Popen(curlCmd, shell = True, stdout=subprocess.PIPE)
            (out, err) = runCurl.communicate()
            matched = self.curlOutCSV(out) #capturing the Curl response
            self.resultList.append((value[0], value[1], value[2], matched))
        with open("output.csv", "wb") as f: #Theoutput is stored in output.csv
            dictWriter = csv.DictWriter(f, delimiter = ',', fieldnames = ["LastName", "FirstName", "E-mail", "Output"])
            dictWriter.writeheader()
            writer = csv.writer(f)
            writer.writerows(self.resultList)
        return self.resultList

    #Method to analyze Curl response
    def curlOutCSV(self, out):
        success = 'HTTP/1.1 201 Created'
        error = '<error-desc>'
        matched = 'matched'
        if success in out:
            matched = re.findall(r'(?<=Location: ).*?(?=orcid-profile)', out)
            matched[0] = matched[0] + 'orcid-profile'
        elif error in out:
            matched = re.findall(r'(?<=<error-desc>).*?(?=</error-desc>)', out)
        return matched[0]

#Main method
if __name__ == "__main__":
    ifpri = ifpri()
    csvInput = ifpri.readCSV() # result is a list of all the users in the format {LastName, FirstName, Email}
    filelist = ifpri.createXML(csvInput) # filelist is the list of all XML file names which are created -- each file is created as LastNameFirstName.xml
    resultList = ifpri.curlORCiD(filelist) # this calls the ORCiD API and creates a csv with the results/errors
    if resultList:
        print "Result:",len(resultList),"record processed"
