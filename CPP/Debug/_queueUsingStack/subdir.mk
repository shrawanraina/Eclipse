################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../_queueUsingStack/_queueUsingStack.cpp 

OBJS += \
./_queueUsingStack/_queueUsingStack.o 

CPP_DEPS += \
./_queueUsingStack/_queueUsingStack.d 


# Each subdirectory must supply rules for building sources it contributes
_queueUsingStack/%.o: ../_queueUsingStack/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


