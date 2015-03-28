################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../_arrays/_arrays.cpp 

OBJS += \
./_arrays/_arrays.o 

CPP_DEPS += \
./_arrays/_arrays.d 


# Each subdirectory must supply rules for building sources it contributes
_arrays/%.o: ../_arrays/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


