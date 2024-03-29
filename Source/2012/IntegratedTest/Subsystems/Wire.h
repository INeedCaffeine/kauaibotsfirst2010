/*
  TwoWire.h - TWI/I2C library for Arduino & Wiring
  Copyright (c) 2006 Nicholas Zambetti.  All right reserved.
  
  Ported to National Instruments cRio / WPI Library
  by Scott Libert, March 2012.

  This library is free software; you can redistribute it and/or
  modify it under the terms of the GNU Lesser General Public
  License as published by the Free Software Foundation; either
  version 2.1 of the License, or (at your option) any later version.

  This library is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
  Lesser General Public License for more details.

  You should have received a copy of the GNU Lesser General Public
  License along with this library; if not, write to the Free Software
  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/

#ifndef TwoWire_h
#define TwoWire_h

#include "I2C.h"
#include "DigitalModule.h"
#include <math.h>

#define NUM_I2C_DEVICES 3
#define BUFFER_LENGTH 32

struct I2CDeviceInfo
{
	I2C *	pDevice;
	uint8_t deviceAddress;
};

class TwoWire
{
  private:
	
    static uint8_t rxBuffer[];
    static uint8_t rxBufferIndex;
    static uint8_t rxBufferLength;

    static uint8_t txBuffer[];
    static uint8_t txBufferIndex;
    static uint8_t txBufferLength;
		
    static uint8_t txAddress;
    static uint8_t transmitting;
    
    static I2CDeviceInfo m_DeviceInfo[NUM_I2C_DEVICES];
    
    static I2C *m_pCurrI2CDevice;
    static UINT8 m_dscModuleNumber;
    
    I2C *GetDeviceByAddress(uint8_t address);
    
  public:
    TwoWire();
    void begin();
    void begin(uint8_t);
    void begin(int);
    void beginTransmission(uint8_t);
    void beginTransmission(int);
    uint8_t endTransmission(void);
    uint8_t requestFrom(uint8_t, uint8_t);
    uint8_t requestFrom(int, int);
    virtual size_t write(uint8_t);
    virtual size_t write(const uint8_t *, size_t);
    virtual int available(void);
    virtual int read(void);
    virtual int peek(void);
	virtual void flush(void);
};

extern TwoWire Wire;

#endif

