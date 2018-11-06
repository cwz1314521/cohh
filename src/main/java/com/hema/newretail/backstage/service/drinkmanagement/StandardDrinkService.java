package com.hema.newretail.backstage.service.drinkmanagement;

import com.hema.newretail.backstage.common.requestparam.MenuParam;
import com.hema.newretail.backstage.entry.BusiIngredientMenuEntry;

/**
 * Created by jiahao on 2018-08-25
 */
public interface StandardDrinkService {

    BusiIngredientMenuEntry selectStandardDrink(String menuName);

    String selectStandardDrink(String menuName, Long id);

    void saveAndUpdateStandardDrink(MenuParam menuParam);

}
