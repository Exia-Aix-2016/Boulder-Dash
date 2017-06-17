package DAO;

/**
 * Interface IMap
 */
public interface IMap {

      /**
       * Search in DataBase map by her id
       * */
      RawMap getMap(final int idMap);
      /**
       * Allow to add in DataBase
       * */
      void addMap(final RawMap rawMap);

      /**
       * remove map with her name
       * @param nameMap name of the map
       * */
      void removeMap(final String nameMap);

      /**
       * remove map with her id
       * @param indexMap name of the map
       * */
      void removeMap(final int indexMap);

}
