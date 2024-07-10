### Hint: Creating and Using a `Comparator`

Consider a company that strictly follows the guideline of creating employee
usernames in the format of first initial followed by last name. An employee
such as Jeff Bezos would be assigned the username `jbezos`.

Sorting a list of such usernames can be accomplished using the `Arrays.sort`
utility. However, this will sort based on the entire username, which starts
with the employee's first initial. There may be times when it is necessary
to sort a list of usernames by the employee's actual last name.

This can be accomplished using a `Comparator`. Consider the following demo
code:

```java
import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        // Create an array of usernames and print them.
        String[] usernames = { "gwashington", "alincoln", "froosevelt", "tjefferson", "jkennedy" };
        System.out.println(String.join(", ", usernames));

        // Sort the usernames and print them again.
        Arrays.sort(usernames);
        System.out.println(String.join(", ", usernames));

        // Comparator to ignore first character.
        Comparator<String> lastNameComparator = new Comparator<String>() {
            @Override
            public int compare(String r, String s) {
                return r.substring(1).compareTo(s.substring(1));
            }
        };

        // Sort the usernames using the comparator and print them one more time.
        Arrays.sort(usernames, lastNameComparator);
        System.out.println(String.join(", ", usernames));
    }
}
```

The output of the above code is:

```
gwashington, alincoln, froosevelt, tjefferson, jkennedy
alincoln, froosevelt, gwashington, jkennedy, tjefferson
tjefferson, jkennedy, alincoln, froosevelt, gwashington
```

The first line of output shows the original usernames, unchanged.
The second line of output shows the sorted usernames, where the
sort included the first character of each username.

The third line of output shows the sorted usernames, where the
`Comparator` used by `Arrays.sort` ignored the first character
when performing the sort. It is important to note the `Comparator`
does not actually change any of the strings being sorted, it just
ignores the first character when comparing them.

* [Still confused?](./hint_01a.md)
