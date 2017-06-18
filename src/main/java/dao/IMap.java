package dao;

import java.util.Optional;

/**
 * Interface IMap. He allows to interact with DataBase.
 */
public interface IMap {

      /**
       * Search in DataBase map by her id
       * @see RawMap
       * */
      Optional<RawMap> getMap(final String nameMap);
      /**
       * Allow to add in DataBase
       * @see RawMap
       * */
      void addMap(final RawMap rawMap);

      /**
       * remove map with her name
       * @param nameMap name of the map
       * */
      void removeMap(final String nameMap);
}
