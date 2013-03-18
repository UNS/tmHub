package net.tmhub;

import java.util.List;
import net.tmhub.obj.*;

public interface Repa {
	public Profile getProfile(String userName);
	public void saveProfile(Profile profle);
	public Profile getProfile(long id);

	public void updateProfile(Profile p);

	public void deleteProfile(Profile p);

	public List<Profile> getProfiles();
}

