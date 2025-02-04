a=1
b=6
def listFunc():
    return [i for i in range(a, b)] #Create list of ints from 1 to 5, Haskell equivalent [1..5]

def applicatorFunc(inpFunc, s):
    if s=='s':
        return sum(inpFunc())
    else:
        return sum(inpFunc())/5

print(applicatorFunc(listFunc, 's'))