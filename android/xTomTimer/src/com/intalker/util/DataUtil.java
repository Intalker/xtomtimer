package com.intalker.util;

import java.util.UUID;

public class DataUtil
{
	public static String makeUUID()
    {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
