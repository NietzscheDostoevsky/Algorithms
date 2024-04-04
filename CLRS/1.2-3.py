n = 1
while 100*(n^2) > (2^n):
    n +=1
    print(n)
    if n > 100:
        print("Error Error Error")
        break
print("Min value that violates the inequality is n = ", n)


# while 100 * n * n  > 2 ** n:
    # this code is working 