# --- Insertion Sort Algorithm -----
# implemented from npseudocode given on page 19, CLRS


# INSERTION SORT PSEUDOCODE
# ---------------------------------------------------------------
#
#    INSERTOIN SORT(A,N)
#        for i = 2 to n
#            key = A[i]
#            // Insert A{i} into the sorted subarrary A[1:i-1]
#            j = i - 1
#            while j > 0 and A[j] > key
#                A[j+1] = A[j]
#                j = j - 1
#            A[j+1] = key
#
# ----------------------------------------------------------------


def insertionsort(a, n=None):
    """Takes an array of size n, and returns it sorted using insertion sort

    Args:
        a (list): a list of comparable elements
        n (integer): size of the array to be sorted
        return : sorted array a
    """

    if n is None:
        n = len(a)
