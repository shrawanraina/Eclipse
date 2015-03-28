################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../_coinChange/_coinChange.cpp 

OBJS += \
./_coinChange/_coinChange.o 

CPP_DEPS += \
./_coinChange/_coinChange.d 


# Each subdirectory must supply rules for building sources it contributes
_coinChange/%.o: ../_coinChange/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


