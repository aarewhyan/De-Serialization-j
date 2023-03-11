package com.DeSerialization;

import java.nio.charset.StandardCharsets;

public class ReaderWriter {
	public static final byte[] HEADER = "RC".getBytes();//Header
	//Version

	public static byte writer(byte[] data,byte position, byte value) {
		data[position++]=value;
		return position;
	}
	public static byte writer(byte[] data,byte position, short value) {
		data[position++]= (byte)(value>>8);
		data[position++]= ((byte) value);
		return position;
	}
	public static byte writer(byte[] data,byte position, char value) {
		data[position++]= (byte)(value>>8);
		data[position++]= (byte)(value);
		return position;
	}
	public static byte writer(byte[] data,byte position, int value) {
		data[position++]= (byte)(value>>24);
		data[position++]= (byte)(value>>16);
		data[position++]= (byte)(value>>8);
		data[position++]= (byte)(value);
		return position;
	}
	public static byte writer(byte[] data,byte position, long value) {
		data[position++]= (byte)(value>>56);
        data[position++]= (byte)(value>>48);
		data[position++]= (byte)(value>>40);
		data[position++]= (byte)(value>>32);
		data[position++]= (byte)(value>>24);
		data[position++]= (byte)(value>>16);
		data[position++]= (byte)(value>>8);
		data[position++]= (byte)(value);
		return position;
	}
	public static void writer(byte[] data, byte position, float value) {
		int nevalue = Float.floatToRawIntBits(value);
		writer(data, position, nevalue);
	}
	public static void writer(byte[] data, byte position, double value) {
		long nevalue = Double.doubleToRawLongBits(value);
		writer(data, position, nevalue);
	}
	public static void writer(byte[] data, byte position, boolean value) {
		
	}
	public static void writer(byte[] data, byte position, String value) {
		value = value+(char)0b0;
		System.out.println(value);
		byte[] nevalue = value.getBytes(StandardCharsets.US_ASCII);
		for (int i=0; nevalue[i]!=(byte)0; i++) {
			position = writer(data, position, nevalue[i]);
		}
	}
	
	
	
	public static byte reader(byte[] data, byte position) {
		return data[position++];
	}
	public static int reader(byte[] data, byte position) {
		return (short) (data[position++]<<8 |data[position++]);
	}
	public static int reader(byte[] data,byte position, char value) {
		return (char)(data[position++] <<8| data[position++]);
	}
	public static int reader(byte[] data,byte position, int value) {
		return data[position++]<<24 | data[position++]<<16 | data[position++]<<8 | data[position++];
	}
	public static int reader(byte[] data,byte position, long value) {
		return data[position++]<<56 | data[position++]<<48 | data[position++]<<40 | data[position++]<<32 | data[position++]<<24 | data[position++]<<16 | data[position++]<<8 | data[position++];
	}
	
}


