from CutleryInterface import CutleryInterface


class CupCutleryAdapter(CutleryInterface):
    length: int
    def __init__(self, source):
        self.source = source
        self.length = source.volume
    def take_food(self) -> str:
        return self.source.pour_liquid()