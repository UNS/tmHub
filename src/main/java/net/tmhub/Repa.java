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

	public void saveState(State p);

	public State getState(long id);

	public List<State> getState();

	public void updateState(State s);

	public void deleteState(State s);

	public void saveTM(TM p);

	public TM getTM(long id);

	public List<TM> getTM();

	public void updateTM(TM s);

	public void deleteTM(TM s);
}
