package kata;

import java.io.*;
import java.util.Arrays;


class Serving
{
	String [] arr;
	
	 String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
             "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
             "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
             "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
             "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
             "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
             "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
	
	public Serving(String [] str) {
		super();
		this.arr = str;
	}
	int a = 0, b = 0, ch_a = -1, ch_b = -1;
	String c;
	
	public void Transform()
	{
		
		try
		{
		a = Integer.parseInt(arr[0]);
		ch_a = 0;
		}
		catch(Exception NumberFormatException)
		{
			a = transformToNumber(arr[0]);
			ch_a = 1;
		}
		try
		{
		b = Integer.parseInt(arr[2]);
		ch_b = 0;
		}
		catch(Exception NumberFormatException)
		{
			b = transformToNumber(arr[2]);
			ch_b = 1;
		}
		c = arr[1];
	}
	
	public int transformToNumber(String arr)
	{
		
		int a = 0;
		
		
		switch (arr) {
	    case "I":
	        a = 1;
	        break;
	    case "II":
	        a = 2;
	        break;   
	    case "III":
	        a = 3;
	        break; 
	    case "IV":
	        a = 4;
	        break;
	    case "V":
	        a = 5;
	        break;
	    case "VI":
	        a = 6;
	        break;
	    case "VII":
	        a = 7;
	        break;
	    case "VIII":
	        a = 8;
	        break;
	    case "IX":
	        a = 9;
	        break;
	    case "X":
	        a = 10;
	        break;
	     default:
	     a = 0;
	     break;
		}
		
		return a;
	}

	public String transformToRom(int a)
	{
		
		String tmp;
		
		tmp = roman[a];
		
		return tmp;
	}
	
	@Override
	public String toString() {
		return "Serving [arr=" + Arrays.toString(arr) + ", a=" + a + ", b=" + b + ", ch_a=" + ch_a + ", ch_b=" + ch_b
				+ ", c=" + c + "]";
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getCh_a() {
		return ch_a;
	}

	public void setCh_a(int ch_a) {
		this.ch_a = ch_a;
	}

	public int getCh_b() {
		return ch_b;
	}

	public void setCh_b(int ch_b) {
		this.ch_b = ch_b;
	}
	
	public int getArr_length() {
		return arr.length;
	}
	
}




class Standart_Calculator
{
	
	int rez = 0;
	
	public int Calculator(int a, int b, String c)
	{
		
	switch (c) {
    case "+":
        rez = a+b;
        break;
    case "-":
        rez = a-b;
        break;   
    case "*":
        rez = a*b;
        break; 
    case "/":
        rez = a/b;
        break;
	}

	
	return rez;
	
	}

	@Override
	public String toString() {
		return "" + rez;
	}

	public int getRez() {
		return rez;
	}

	public void setRez(int rez) {
		this.rez = rez;
	}
	
}


public class Main {

	public static void main(String [] args) throws IOException
	{
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	String s = bufferedReader.readLine();
	String rez_rom;
	int a, b, ch_a, ch_b, rez;
	
	String [] arr = s.split(" ");
	
	Serving sv = new Serving(arr);
	
	Standart_Calculator sc = new Standart_Calculator();
	
	
	if(arr.length == 1)//проверка формат матоперации
	{
		System.out.println("throws Exception //т.к. строка не является математической операцией");
		return;
	}
	

	
	
	if(arr.length > 3)//проверка формат матоперации
	{
		System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
		return;
	}
	
	sv.Transform();
	
	ch_a = sv.getCh_a();
	ch_b = sv.getCh_b();
	
	if(ch_a == ch_b)//проверка на использование систем исчисления
	{
	a = sv.getA();
	b = sv.getB();
	}
	else
	{
		System.out.println("throws Exception, т.к. используются одновременно разные системы счисления или не все числа целые");
		return;
		
	}
	
	
	if(a > 10 || a < 1 || b > 10 || b < 1)
	{
		
		System.out.println("throws Exception //т.к. не выполнено условие: только цифры от 1 до 10");
		return;
	}
	

	String c = sv.getC();
	sc.Calculator(a,b ,c );
	
	
	rez = sc.getRez();
	
	if(ch_a == 1)//проверка на римские
	{
		if(rez < 0 || rez == 0)
		{
			System.out.println("throws Exception //т.к. в римской системе исчисления нет отрицательных чисел и нуля");
			return;
		}
			
		else
			{
			
			rez_rom = sv.transformToRom(rez);
			System.out.println(rez_rom);
			
			}
	}
	else System.out.println(rez);
	

	
	
	}
}
