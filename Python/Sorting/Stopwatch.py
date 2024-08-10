import time

class Stopwatch:
    def __init__(self) -> None:
        #Constructor 
        self.start = time.perf_counter()

    def elapsed_time(self):
        now = time.time()
        return now - self.start 