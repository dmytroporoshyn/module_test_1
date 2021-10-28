package com.dmytroporoshyn;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Test addItem method")
class ShoppingCartAddItemTest {

    private final ShoppingCart cart = new ShoppingCart();
    private final ShoppingCart hundredItemsCart = new ShoppingCart();

    @Test
    @DisplayName("Test item title")
    void testItemTitle() {
        //negative cases
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("", 10, 1, Item.Type.REGULAR),
                "Failed to validate empty title");
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem(null, 10, 1, Item.Type.REGULAR),
                "Failed to validate null title");
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Lorem ipsum dolor sit amet, consectetur", 10, 1, Item.Type.REGULAR),
                "Failed to validate more than 32 characters in title");

        //positive case
        assertDoesNotThrow(() -> cart.addItem("Lorem ipsum", 10, 1, Item.Type.REGULAR),
                "Failed to verify the correct item title.");
    }

    @Test
    @DisplayName("Test item price")
    void testItemPrice() {
        //negative cases
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Item 0 price", 0, 10, Item.Type.REGULAR),
                "Test 0 price is failed");
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Item -1 price", -1, 10, Item.Type.REGULAR),
                "Test -1 price is failed");
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Item 1001 price", 1001, 10, Item.Type.REGULAR),
                "Test 1001 price is failed");

        //positive case
        assertDoesNotThrow(
                () -> cart.addItem("Item 100 price", 100, 10, Item.Type.REGULAR),
                "Test 100 price is failed");
    }

    @Test
    @DisplayName("Test item quantity")
    void testItemQuantity() {
        //negative cases
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Item -1 Quantity", 1, -1, Item.Type.REGULAR),
                "Test -1 quantity item is failed");
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Item 0 Quantity", 1, 0, Item.Type.REGULAR),
                "Test 0 quantity item is failed");
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Item 999 Quantity", 1, 1001, Item.Type.REGULAR),
                "Test 1001 quantity item is failed");

        //positive case
        assertDoesNotThrow(() -> cart.addItem("Item 10 Quantity", 1, 10, Item.Type.REGULAR),
                "Test 1 quantity item is failed");
    }

    @Test
    @DisplayName("Test 100 items in the card")
    void testAddHundredItems() {
        //add 99 items
        for (int i = 1; i < 100; i++) {
            assertDoesNotThrow(() -> hundredItemsCart.addItem("Item tile", 1, 1, Item.Type.REGULAR));
        }

        //add 100 item
        assertThrows(IndexOutOfBoundsException.class,
                () -> hundredItemsCart.addItem("Item 100", 1, 1, Item.Type.REGULAR),
                "Test adding of 100 items is failed");
    }
}
