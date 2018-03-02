package id.ac.ui.cs.advprog.tutorial3.decorator;

import id.ac.ui.cs.advprog.tutorial3.decorator.bread.BreadProducer;
import id.ac.ui.cs.advprog.tutorial3.decorator.bread.CrustySandwich;
import id.ac.ui.cs.advprog.tutorial3.decorator.bread.NoCrustSandwich;
import id.ac.ui.cs.advprog.tutorial3.decorator.bread.ThickBunBurger;
import id.ac.ui.cs.advprog.tutorial3.decorator.bread.ThinBunBurger;

import id.ac.ui.cs.advprog.tutorial3.decorator.filling.FillingDecorator;

public class Main {
    public static void main(String[] args) {
        Food thickBunBurgerSpecial = new ThickBunBurger();
        Food thinBunBurgerVegetarian = new ThinBunBurger();
        Food doubleBeefChickenDoubleSauceSandwich = new CrustySandwich();
        Food noCrustAllFillingSandwich = new NoCrustSandwich();

        //Thick Bun Burger with Beef Meat, Cheese, Cucumber, Lettuce, and Chili Sauce
        thickBunBurgerSpecial = BreadProducer.THICK_BUN.createBreadToBeFilled();
        System.out.println(thickBunBurgerSpecial.getDescription() + " - "
            + thickBunBurgerSpecial.cost());

        thickBunBurgerSpecial = FillingDecorator.BEEF_MEAT.addFillingToBread(
                thickBunBurgerSpecial);
        System.out.println(thickBunBurgerSpecial.getDescription() + " - "
            + thickBunBurgerSpecial.cost());

        thickBunBurgerSpecial = FillingDecorator.CHEESE.addFillingToBread(
                thickBunBurgerSpecial);
        System.out.println(thickBunBurgerSpecial.getDescription() + " - "
            + thickBunBurgerSpecial.cost());

        thickBunBurgerSpecial = FillingDecorator.CUCUMBER.addFillingToBread(
                thickBunBurgerSpecial);
        System.out.println(thickBunBurgerSpecial.getDescription() + " - "
            + thickBunBurgerSpecial.cost());

        thickBunBurgerSpecial = FillingDecorator.LETTUCE.addFillingToBread(
                thickBunBurgerSpecial);
        System.out.println(thickBunBurgerSpecial.getDescription() + " - "
            + thickBunBurgerSpecial.cost());

        thickBunBurgerSpecial = FillingDecorator.CHILI_SAUCE.addFillingToBread(
                thickBunBurgerSpecial);
        System.out.println(thickBunBurgerSpecial.getDescription() + " - "
            + thickBunBurgerSpecial.cost());

        //Thin Bun Burger with Tomato, Lettuce, Cucumber
        thinBunBurgerVegetarian = BreadProducer.THIN_BUN.createBreadToBeFilled();
        System.out.println(thinBunBurgerVegetarian.getDescription() + " - "
            + thinBunBurgerVegetarian.cost());

        thinBunBurgerVegetarian = FillingDecorator.TOMATO.addFillingToBread(
                thinBunBurgerVegetarian);
        System.out.println(thinBunBurgerVegetarian.getDescription() + " - "
            + thinBunBurgerVegetarian.cost());

        thinBunBurgerVegetarian = FillingDecorator.LETTUCE.addFillingToBread(
                thinBunBurgerVegetarian);
        System.out.println(thinBunBurgerVegetarian.getDescription() + " - "
            + thinBunBurgerVegetarian.cost());

        thinBunBurgerVegetarian = FillingDecorator.CUCUMBER.addFillingToBread(
                thinBunBurgerVegetarian);
        System.out.println(thinBunBurgerVegetarian.getDescription() + " - "
            + thinBunBurgerVegetarian.cost());

        //Crusty Sandiwich with Beef Meat, Chicken Meat, Using Tomato and Chili Sauce
        doubleBeefChickenDoubleSauceSandwich =
                BreadProducer.CRUSTY_SANDWICH.createBreadToBeFilled();
        System.out.println(doubleBeefChickenDoubleSauceSandwich.getDescription() + " - "
            + doubleBeefChickenDoubleSauceSandwich.cost());

        doubleBeefChickenDoubleSauceSandwich =
                FillingDecorator.BEEF_MEAT.addFillingToBread(
                        doubleBeefChickenDoubleSauceSandwich);
        System.out.println(doubleBeefChickenDoubleSauceSandwich.getDescription() + " - "
                + doubleBeefChickenDoubleSauceSandwich.cost());

        doubleBeefChickenDoubleSauceSandwich =
                FillingDecorator.CHICKEN_MEAT.addFillingToBread(
                        doubleBeefChickenDoubleSauceSandwich);
        System.out.println(doubleBeefChickenDoubleSauceSandwich.getDescription() + " - "
                + doubleBeefChickenDoubleSauceSandwich.cost());

        doubleBeefChickenDoubleSauceSandwich =
                FillingDecorator.CHILI_SAUCE.addFillingToBread(
                        doubleBeefChickenDoubleSauceSandwich);
        System.out.println(doubleBeefChickenDoubleSauceSandwich.getDescription() + " - "
                + doubleBeefChickenDoubleSauceSandwich.cost());

        doubleBeefChickenDoubleSauceSandwich =
                FillingDecorator.TOMATO_SAUCE.addFillingToBread(
                        doubleBeefChickenDoubleSauceSandwich);
        System.out.println(doubleBeefChickenDoubleSauceSandwich.getDescription() + " - "
                + doubleBeefChickenDoubleSauceSandwich.cost());

        //No Crust Sandiwich with All Filling
        noCrustAllFillingSandwich = BreadProducer.NO_CRUST_SANDWICH
                .createBreadToBeFilled();
        System.out.println(noCrustAllFillingSandwich.getDescription() + " - "
                + noCrustAllFillingSandwich.cost());

        noCrustAllFillingSandwich = FillingDecorator.BEEF_MEAT.addFillingToBread(
                noCrustAllFillingSandwich);
        System.out.println(noCrustAllFillingSandwich.getDescription() + " - "
                + noCrustAllFillingSandwich.cost());

        noCrustAllFillingSandwich = FillingDecorator.CHEESE.addFillingToBread(
                noCrustAllFillingSandwich);
        System.out.println(noCrustAllFillingSandwich.getDescription() + " - "
                + noCrustAllFillingSandwich.cost());

        noCrustAllFillingSandwich = FillingDecorator.CHICKEN_MEAT.addFillingToBread(
                noCrustAllFillingSandwich);
        System.out.println(noCrustAllFillingSandwich.getDescription() + " - "
                + noCrustAllFillingSandwich.cost());

        noCrustAllFillingSandwich = FillingDecorator.CHILI_SAUCE.addFillingToBread(
                noCrustAllFillingSandwich);
        System.out.println(noCrustAllFillingSandwich.getDescription() + " - "
                + noCrustAllFillingSandwich.cost());

        noCrustAllFillingSandwich = FillingDecorator.CUCUMBER.addFillingToBread(
                noCrustAllFillingSandwich);
        System.out.println(noCrustAllFillingSandwich.getDescription() + " - "
                + noCrustAllFillingSandwich.cost());

        noCrustAllFillingSandwich = FillingDecorator.LETTUCE.addFillingToBread(
                noCrustAllFillingSandwich);
        System.out.println(noCrustAllFillingSandwich.getDescription() + " - "
                + noCrustAllFillingSandwich.cost());

        noCrustAllFillingSandwich = FillingDecorator.TOMATO.addFillingToBread(
                noCrustAllFillingSandwich);
        System.out.println(noCrustAllFillingSandwich.getDescription() + " - "
                + noCrustAllFillingSandwich.cost());

        noCrustAllFillingSandwich = FillingDecorator.TOMATO_SAUCE.addFillingToBread(
                noCrustAllFillingSandwich);
        System.out.println(noCrustAllFillingSandwich.getDescription() + " - "
                + noCrustAllFillingSandwich.cost());
    }
}