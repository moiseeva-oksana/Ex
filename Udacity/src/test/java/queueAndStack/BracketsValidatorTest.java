package queueAndStack;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BracketsValidatorTest {
    private BracketsValidator validator = new BracketsValidator();
    @Test
    public void validate() throws Exception {
        assertThat(validator.validate("([])"), is(true));
        assertThat(validator.validate("([)]"), is(false));
        assertThat(validator.validate("(([])"), is(false));
        assertThat(validator.validate("(a+[*(2+2)*]~]"), is(false));
        assertThat(validator.validate("(a+[*(2+2)*]~)"), is(true));

    }

}