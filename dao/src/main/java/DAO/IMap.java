package DAO;

/**
 * Created by Mandel on 16/06/2017.
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

}
