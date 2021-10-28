package com.dmytroporoshyn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ShoppingCartCalculateDiscountTest {

    @DisplayName("Test discount calculation for the card")
    @ParameterizedTest(name = "When type = {1} and quantity = {2} then discount should = {0}")
    @MethodSource("calculateDiscountsSource")
    public void calculateDiscountsTest(int expectedDiscount, Item.Type type, int quantity) {
        assertEquals(expectedDiscount,
                ShoppingCart.calculateDiscount(new Item("Item", 1, type, quantity)));
    }


    static Stream<Arguments> calculateDiscountsSource() {
        return Stream.of(
                arguments(0, Item.Type.REGULAR, 1),
                arguments(0, Item.Type.REGULAR, 50),
                arguments(10, Item.Type.REGULAR, 100),
                arguments(20, Item.Type.REGULAR, 200),
                arguments(80, Item.Type.REGULAR, 800),
                arguments(80, Item.Type.REGULAR, 9000),
                arguments(0, Item.Type.SECOND, 1),
                arguments(50, Item.Type.SECOND, 2),
                arguments(60, Item.Type.SECOND, 100),
                arguments(80, Item.Type.SECOND, 300),
                arguments(80, Item.Type.SECOND, 400),
                arguments(10, Item.Type.DISCOUNT, 1),
                arguments(10, Item.Type.DISCOUNT, 9),
                arguments(20, Item.Type.DISCOUNT, 10),
                arguments(20, Item.Type.DISCOUNT, 15),
                arguments(30, Item.Type.DISCOUNT, 20),
                arguments(50, Item.Type.DISCOUNT, 40),
                arguments(50, Item.Type.DISCOUNT, 60),
                arguments(60, Item.Type.DISCOUNT, 100),
                arguments(80, Item.Type.DISCOUNT, 300),
                arguments(80, Item.Type.DISCOUNT, 400),
                arguments(90, Item.Type.SALE, 1),
                arguments(90, Item.Type.SALE, 100)
        );
    }
}
