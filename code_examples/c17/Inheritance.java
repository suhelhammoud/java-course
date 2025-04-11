package c17;

class A { /* ... */ }
interface B { /* ... */ }
interface C { /* ... */ }

class D <T extends A & B & C> { /* ... */ }

//class E <T extends B & A & C> { /* ... */ }  // compile-time error class A must be first
