
stars = input("Enter number of stars to print : ")
stars = int(stars)
str = "*".join("*"*stars)
print(str)

for star in range(stars) : 
    print("*    *")
print(str)
    
