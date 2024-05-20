# ---------------------------------------------------------------------
#
# Your task is to sort a given string. 
# Each word in the string will contain a single number. 
# This number is the position the word should have in the result.

# Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

# If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.
#
# --------------------------------------------------------------------


# "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
# "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
# ""  -->  ""

# ---------------------------------------------------------------------

#%%
def order(sentence):
    if sentence == "":
        return ""
    returnString = ""
    input = sentence.split()
    indexdict = {}
    for word in input : 
        for char in word:
            if char.isalpha():
                continue
            else : 
                index = int(char) 
                indexdict[index] = word 
    myKeys = list(indexdict.keys())
    myKeys.sort() 
    sortedDict = {i:indexdict[i] for i in myKeys}
    stringList = [sortedDict[i] for i in myKeys]
    x = " ".join(stringList)
    returnString = x    

    return returnString

#%%

ts1 = "is2 Thi1s T4est 3a" 
os1 = "Thi1s is2 3a T4est"
ts2 = "4of Fo1r pe6ople g3ood th5e the2"
os2 = "Fo1r the2 g3ood 4of th5e pe6ople"
ts3 = ""
os3 = ""
# %%
