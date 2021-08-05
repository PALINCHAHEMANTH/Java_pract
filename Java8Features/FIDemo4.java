// Not a Functional Interface : because equals() is already an implicit member (Object class)
interface Foo1 { 
	boolean equals(Object obj); 
}
//---------------------------------------------------------------------------------------------------------
// Functional Interface : because Comparator has only ONE abstract NON-Object method
interface Comparator<T> {
	int compare(T o1, T o2);
	boolean equals(Object obj);
}
//---------------------------------------------------------------------------------------------------------
// Not a Functional Interface : Because method Object.clone() is not public
interface Foo2 {
	int m();
	Object clone();
}
//---------------------------------------------------------------------------------------------------------
// Functional interface : two methods, but they have the same signature
interface X { 
	int m1(Iterable<String> arg); 
}
interface Y { 
	int m1(Iterable<String> arg); 
}
interface Z extends X, Y {
}
//---------------------------------------------------------------------------------------------------------
// Functional interface : two methods, but they have the same signature where Exceptions are parameters
interface X1 { 
	int m1(ArithmeticException arg); 
}
interface Y1 { 
	int m1(ClassNotFoundException arg);
}
interface Z1 extends X1, Y1 {
}
//---------------------------------------------------------------------------------------------------------
// Functional interface : B.m1 is a subsignature & return-type-substitutable
interface A { 
	Iterable m1(Iterable<String> arg); 
}
interface B { 
	Iterable<String> m1(Iterable arg);
}
interface C extends A, B {
}
//---------------------------------------------------------------------------------------------------------
// Not functional interface : No method has a subsignature of all abstract methods
interface X2 { 
	int m2(Iterable<String> arg); 
}
interface Y2 { 
	int m2(Iterable<Integer> arg); 
}
//interface Z2 extends X2, Y2 {
//}
//---------------------------------------------------------------------------------------------------------
// Not functional interface : No method has a subsignature of all abstract methods
interface X3 { 
	int m3(Iterable<String> arg, Class c); 
}
interface Y3 { 
	int m3(Iterable arg, Class<?> c); 
}
//interface Z3 extends X3, Y3 {
//}
//---------------------------------------------------------------------------------------------------------
// Compiler error : no method is return type substitutable - unrealted RETURN TYPES
interface X4 { long m4(); }
interface Y4 { int m4();  }
//interface Z4 extends X4, Y4 {}
//---------------------------------------------------------------------------------------------------------
// Compiler error : different signatures, same erasure
interface Foo3<T> { void m(T arg); }
interface Bar<T>  { void m(T arg); }
//interface FooBar<X, Y> extends Foo3<X>, Bar<Y> {}
//---------------------------------------------------------------------------------------------------------
public class FIDemo4
{
	public static void main(String[] args) 
	{}
}
