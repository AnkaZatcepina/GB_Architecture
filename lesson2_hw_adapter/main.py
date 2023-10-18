from Fork import Fork
from Cup import Cup
from CupCutleryAdapter import CupCutleryAdapter

fork = Fork()
print(fork.length)
print(fork.take_food())
cup = Cup()
cup_adapter = CupCutleryAdapter(cup)
print(cup_adapter.length)
print(cup_adapter.take_food())