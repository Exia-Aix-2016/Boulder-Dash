package dao;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Interface IMap. He allows to interact with DataBase.
 */
public interface IMap {

      /**
       * Search in DataBase map by her id
       * @return Optional encapsulate RawMap if method is success return Optional(RawMap) else Optional.empty()
       * @see RawMap
       * @see Optional
       * */
      Optional<RawMap> getMap(final String nameMap);
      /**
       * Allow to add in DataBase
       * @param rawMap representation of Map
       * @see RawMap
       * */
      void addMap(final RawMap rawMap);

      /**
       * @return List of map (with there name)
       * */
      ArrayList<String> getMapListNames();
      /**
       * remove map with her name
       * @param nameMap name of the map
       * */
      void removeMap(final String nameMap);
}
