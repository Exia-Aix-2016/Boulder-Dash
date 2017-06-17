package DAO;

/**
 * Interface IMap. He allows to interact with DataBase.
 */
public interface IMap {

      /**
       * Search in DataBase map by her id
       * @see RawMap
       * */
      RawMap getMap(final int idMap);
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
