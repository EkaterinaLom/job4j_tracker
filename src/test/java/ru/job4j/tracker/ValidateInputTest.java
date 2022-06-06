package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInputTru() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInputTooMuch() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"1", "2"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        int sel2 = input.askInt("Enter menu:");
        assertThat(selected, is(1));
        assertThat(sel2, is(2));
    }

    @Test
    public void whenInvalidInputMinus() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"-1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}