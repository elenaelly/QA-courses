import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both 
 * {@link Demo#main(String[])} and 
 * {@link Demo#isTriangle(double, double, double)}).
 */
public class DemoTest {

    // positive tests

    // 1. to test positive numbers in all 3 fields, scalene triangle

    @Test
    public void test_is_triangle_scalene_all_positive_1() {
        assertTrue(Demo.isTriangle(6, 2, 5));
    }

    // 2. jumble p1, scalene triangle
    @Test
    public void test_is_triangle_scalene_all_positive_2() {
        assertTrue(Demo.isTriangle(2, 5, 6));
    }

    // 3. jumble p1, scalene triangle
    @Test
    public void test_is_triangle_scalene_all_positive_3() {
        assertTrue(Demo.isTriangle(5, 6, 2));
    }

    // 4. decimals, equilateral triangle
    @Test
    public void test_is_triangle_numeric() {
        assertTrue(Demo.isTriangle(2.5, 2.5, 2.5));
    }

    // 5. isosceles triangle

    @Test
    public void test_is_triangle_isosceles() {
        assertTrue(Demo.isTriangle(5, 5, 8));
    }

    // negative tests

    // 6. not a triangle, all positive

    public void test_is_NOT_triangle_all_positive() {
        assertFalse(Demo.isTriangle(12, 15, 30));
    }

    // 7. zero in one field

    @Test
    public void test_is_NOT_triangle_one_zero() {
        assertFalse(Demo.isTriangle(1, 0, 3));
    }

    // 8. negative in one field

    @Test
    public void test_is_NOT_triangle_one_negative() {
        assertFalse(Demo.isTriangle(-1, 2, 3));
    }

    // 9. all zeroes

    @Test
    public void test_is_NOT_triangle_all_zeros() {
        assertFalse(Demo.isTriangle(0, 0, 0));
    }

/** 10. This was to test an empty input.
 @Test
    public void test_is_NOT_triangle_one_missing() {
        assertFalse(Demo.isTriangle(5, 5, ));
    }
 */

/** 11. This was to test zeroes before numbers. Seems they aren't expected
    @Test
    public void test_is_NOT_triangle_zeroes_before() {
        assertFalse(Demo.isTriangle(06, 02, 05));
    }
 */

}

