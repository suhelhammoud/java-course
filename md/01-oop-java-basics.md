---
theme:
  override:
    code:
        alignment: left
        margin:
            percent: 5
    #   padding:
        # horizontal: 4
---

Creating Variables and Naming Them
===



### **Variables in Java**  
- Objects store state in **fields**.  
- Example:  

```java
  int cadence = 0;
  int speed = 0;
  int gear = 1;
```  
- Questions to explore:  
  - Naming rules?  
  - Data types?  
  - Initialization rules?  
  - Default values?  

<!-- end_slide -->


### **Types of Variables**  

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->


1. **Instance Variables (Non-Static Fields)**  
   - Unique to each object.  
   - Declared *without* `static`.  
   - Example: `currentSpeed` of a bicycle. 
<!-- new_line -->


2. **Class Variables (Static Fields)**  
   - Shared across all instances.  
   - Declared with `static`.  
   - Example:  

```java
// Shared by all bicycles
static int numGears = 6;
```  
<!-- column: 1 -->

3. **Local Variables**  
   - Temporary state in methods.  
   - Declared *inside* method braces.  
   - Example:  
```java
int count = 0;
// Local to method
```  

4. **Parameters**  
   - Variables in method signatures.  
   - Example:  
```java
// 'args' is a parameter
public static void main(String[] args) 
```  
<!-- reset_layout -->

**Note:**  
- "Fields" = instance + class variables.  
- "Variables" = all types (including locals/parameters).  

<!-- end_slide -->



# **Naming Conventions**  

Use **meaningful names** for variables.This is better for self documentation and readability.
<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->

### **Rules:**  
  - Case-sensitive (`speed ≠ Speed`).  
  - Start with: letter, `$`, or `_` (but avoid `$` and `_` ).  
  - No whitespace/keywords (e.g., `int static = 0;` ❌ ).  

<!-- pause -->
### **Best Practices:**  
  - Use full words (`gearRatio` over `gr`).  
  - camelCase for variables (`currentGear`).  
  - UPPER_CASE for constants (`MAX_SPEED`).  

<!-- column: 1 -->
<!-- pause -->

### **Examples**  
<!-- pause -->
- **Good Names:**  
```java
int gearRatio;  
static final int MAX_GEARS = 6;  
```  
<!-- pause -->
- **Avoid:**  
```java
int g; // Cryptic  
int $speed; // Non-standard  
```  

<!-- reset_layout -->


