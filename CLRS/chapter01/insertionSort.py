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
    Returns:
        list: sorted array a
    """
    # Make a copy of the original list to preserve it
    a_copy = a.copy()

    if n is None:
        n = len(a_copy)

    for i in range(1, n):
        key = a_copy[i]

        # Inserting a[i] into the sorted subarray
        j = i - 1
        while j >= 0 and a_copy[j] > key:
            a_copy[j + 1] = a_copy[j]
            j = j - 1
        a_copy[j + 1] = key

    return a_copy


a = [5, 3, 4, 6, 1, 3]

b = insertionsort(a)
print(a)
print("-------------------")
print(b)
