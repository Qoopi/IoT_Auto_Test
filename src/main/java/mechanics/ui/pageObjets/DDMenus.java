package mechanics.ui.pageObjets;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by user on 07.03.2017.
 */
public interface DDMenus {
    @Step("Checkout active columns statement in Reports")
    void checkMenuReports();

    @Step("Checkout active columns statement in Equipment")
    void checkMenuEquipment();

    @Step("Checkout active columns statement in Notification List")
    void checkMenuNotificationList();

    @Step("Checkout active columns statement in Notification Rules")
    void checkMenuNotificationRules();

    @Step("Checkout active columns statement in Administration menu - Requests")
    void checkMenuAdministrationRequests();

    @Step("Checkout active columns statement in Administration menu - User List")
    void checkMenuAdministrationUserList();

    @Step("Checkout active columns statement in Administration menu - Equipment List")
    void checkMenuAdministrationEquipmentList();
}
