package testutils;

/**
 * this class contains custom comparison for tests
 */
public class CustomComparator {

    /**
     *
     * @param value1
     * @param value2
     * @param range range to be specified, if difference equal or smaller than range
     *              returns true else false
     * @return boolean value
     */
    public boolean comparePermissibleRange(Double value1, Double value2, Double range){
        if (value1>value2)
            return (value1 - value2) <= range;
        else
            return (value2 - value1) <= range;
    }

}
