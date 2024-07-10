### Hint: Creating and Using a `Comparator` with a `TreeMap`

This exercise requires a `TreeMap` that sorts its key values based
on the state code in a vehicle description. The state code starts
in the second character of the vehicle description, so ignoring
the first character will accomplish the desired sorting. In other
words, for this exercise you will need to create a `Comparator`
nearly identical to the `lastNameComparator` in the previous hint.

When using a `Comparator` with a `TreeMap`, the `Comparator` object
must be given to the `TreeMap` when it is constructed. So, after creating
a `Comparator` object similar to the previous hint, pass it to the `TreeMap`
constructor when creating the second `TreeMap` in the `TollRoad` application
that will sort the key values based on state code.
