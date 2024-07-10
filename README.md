### Multiple `TreeMaps` Using a `Comparator`

Expected time required: 30 min

In this exercise you will reinforce your knowledge of the `TreeMap` by
creating a `TollRoad` application that is very similar to the earlier
`ParticipantDirectory` application. Specifically, you will create a
`TollRoad` application that keeps track of how many tolls a set of
vehicles owe. The application will receive information from automated
toll cameras placed along the toll road. The application provides
reports sorted by vehicle description or by vehicle state of registration.

For example, consider the following list of `Vehicle` description strings:

```
"CCO123ABC", "CIA432LMN", "TCO789XYZ", "SFL456DEF", "TCO789XYZ", "CIA432LMN",
"TCO789XYZ", "TIA765QRS", "CCO123ABC", "SFL456DEF", "CIA432LMN", "TCO789XYZ"
```
Notice several of the vehicle description strings appear twice. This is not
a mistake as it indicates the vehicle passed multiple toll cameras.

With the above data, the `TollRoad` application would be able to produce
the following two reports:

```
Vehicle Tolls By Description:
Description: CCO123ABC, Toll Count: 2
Description: CIA432LMN, Toll Count: 3
Description: SFL456DEF, Toll Count: 2
Description: TCO789XYZ, Toll Count: 4
Description: TIA765QRS, Toll Count: 1

Vehicle Tolls By State:
Description: CCO123ABC, Toll Count: 2
Description: TCO789XYZ, Toll Count: 4
Description: SFL456DEF, Toll Count: 2
Description: CIA432LMN, Toll Count: 3
Description: TIA765QRS, Toll Count: 1
```

The first report is sorted by vehicle type (the first character in the
vehicle description string) and the second report is sorted by the
state of registration for each vehicle (the second and third characters
in the vehicle description string.)

##### `Vehicle` Class
To begin, you will use an existing `Vehicle` class. The first attribute
of a `Vehicle` is a `String` description. In this description, the first
character indicates the vehicle's type; C = car, T = truck, S = semi-trailer,
etc. The next two characters are the vehicle's state code; CO = Colorado,
FL = Florida, IA = Iowa, etc. The remaining characters are the vehicle's
license plate. *This vehicle description code is the information obtained
by the toll road's automated cameras and passed to the `TollRoad` application.
Your code does not generate these.*

The second attribute of a `Vehicle` is a count of how many tolls the vehicle
owes. The `Vehicle` object will not be created until it passes through a toll
road camera for the first time, so the count is initialized to `1`.
The `addToll()` method in the `Vehicle` class increments the vehicle's toll
count. Take a few minutes now to familiarize yourself with the `Vehicle` class.
**Note**: Completing this exercise does ***not*** require making any
changes to the `Vehicle` class.

##### `TollRoad` Class

The `TollRoad` class will keep two separate `TreeMaps`, very similar to
the previous `ParticipantDirectory` exercise. The first `TreeMap` will use
the `String` description attribute in the `Vehicle` class as the key. This
will produce an ordering of the keys based on vehicle type since that
character is the first in the string.

The second `TreeMap` will also need to use the `String` description
attribute in the `Vehicle` class as the key. However, this `TreeMap` 
will need to use a `Comparator` to sort the keys based on the
second and third characters, which represent the state code.

With these two `TreeMaps`, implementing the `getVehicleReportByDescription()`
and `getVehicleReportByState()` methods in the `TollRoad` application will be
nearly identical to the `getRoster` methods in the `ParticipantDirectory`
class from the previous exercise.

The `addToll()` method in the `TollRoad` class will be called by the automated
cameras placed on the toll road (*your code does not need to worry about when or
how this actually happens*.) The `String` parameter is a `Vehicle` description.
If a vehicle with this description has already passed a toll camera, then its
toll count should be incremented. If this is the first time this vehicle has
passed a toll camera, a new `Vehicle` object is created and placed in the toll
road's two `TreeMaps`.

### Exercise

Your task to complete the `TollRoad` class for this exercise is as follows:

* Declare two `TreeMap` variables to associate a `String` key with a `Vehicle` value.
* Complete the `TollRoad` constructor:
  * Create the first `TreeMap` - nothing out of the ordinary with this one.
  * Create a `Comparator` that will compare vehicle description strings
      starting with the second character as that is the beginning of the state
      abbreviation. (See this [hint](./hints/hint_01.md), if necessary.)
  * Create the second `TreeMap`, passing the `Comparator` object to the
      `TreeMap` constructor so it will be used when sorting keys.
* Complete the `addToll()` method:
  * Lookup the given vehicle description string in a `TreeMap`.
  * If there is not currently a `Vehicle` associated with this description
      string, create one and put it in each of the two `TreeMaps`.
  * If there is a `Vehicle` associated with this description string, call
      that vehicle's `addToll()` method to increment its toll counter. 
* Complete the `getVehicleReportByDescription()` method (very similar to the
    `getRoster` methods in the `ParticipantDirectory` exercise.)
* Complete the `getVehicleReportByState()` method (very similar to the
    `getRoster` methods in the `ParticipantDirectory` exercise.)

HINTS:
* [How to use a comparator?](./hints/hint_01.md)
