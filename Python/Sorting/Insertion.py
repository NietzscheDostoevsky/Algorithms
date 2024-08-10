import sys

class Insertion:
    @staticmethod
    def sort(a):
        N = len(a)
        for i in range(N): 
            j = i
            while j > 0 and Insertion.less(a[j], a[j-1]):
                Insertion.exch(a, j, j-1)
                j -= 1
    @staticmethod
    def less(v, w):
        return v < w
    
    @staticmethod
    def exch(a, i, j):
        a[i], a[j] = a[j], a[i]
    
    @staticmethod
    def show(a):
        for item in a:
            print(item, end=" ")
        print()
    
    @staticmethod
    def is_sorted(a):
        for i in range(1, len(a)):
            if Insertion.less(a[i], a[i - 1]):
                return False
        return True

def main():
    # read input from command line
    a = sys.stdin.read().split()

    Insertion.sort(a)
    assert Insertion.is_sorted(a)
    Insertion.show(a)

if __name__ == "__main__":
    main()
    
