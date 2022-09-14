package Strategy;

import entities.PlayList;

import java.util.Collections;
import java.util.List;

public class RandomShuffleBehavior implements IShuffleBehaviour
{
    @Override
    public void shuffle(PlayList playList) {
        Collections.shuffle((List<?>) playList);
    }
}
