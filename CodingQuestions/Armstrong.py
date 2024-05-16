def narcissistic(value):
    nums = [int(num) for num in (str(value).split())[0]]
    sum = 0
    for num in nums:
        sum += num ** (len(nums))
    if sum == value:
        return True
    return False  # Code away

narcissistic(153)
