package net.tmhub;

import net.tmhub.obj.*;

public interface Repa {
	public Profile getProfile(String userName);
	public void saveProfile(Profile profle);
	public Profile getProfile(long id);
}

