import math
from math import * 

# -- For n.lg(n) -- 

n = 1 

while (n * math.log(n, 2)) <  1000000 :
    n += 1
    if n == 10000000 :
        print("error error error")
        break

print("max n size for n lg n in one sec is : " , n)

# -----  for n! ----- 
n = 1
while math.factorial(n) < 1000000:
    n += 1

print("Minimum value of n (n!)     :", n )