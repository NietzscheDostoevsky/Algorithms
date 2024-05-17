#%%

#%%
def to_jaden_case(string):
    
    ogString = string.split()
    newString = []
    
    for word in ogString : 
       newword =  word.split()[0][0].upper() + word.split()[0][1:]
       newString.append(newword)
    
    x = " ".join(newString)
    
    return x
        
# %%
string = "How can mirrors be real if our eyes aren't real"
to_jaden_case(string)
# %%
