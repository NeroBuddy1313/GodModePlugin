package de.nerobuddy.godmode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author m_wei
 * @project GodModePlugin
 * @created 01.09.2022 - 21:51
 */

public final class Data {

    private Data() {
    }

    private static final String PREFIX = "§8[§6GodMode§8] ";

    private static final List<UUID> GOD_MODE_LIST = new ArrayList<>();

    public static String getPrefix() {
        return PREFIX;
    }

    public static List<UUID> getGodModeList() {
        return GOD_MODE_LIST;
    }
}
