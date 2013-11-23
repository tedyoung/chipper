package com.jitterpig.chipper;

import com.google.common.base.Joiner;
import com.jitterpig.chipper.domain.ChipEntry;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.Test;

/**
 *
 */
public class MongoHqTest {
  @Test
  public void store() throws Exception {
    ChipEntry chipEntry = ChipEntry.entry().addChips(3).readMinutes(30).readBook("White House White-Out").readPages(22);
    MongoClientURI uri = new MongoClientURI("mongodb://chipper:transactiondomainmodeladdsubtractamount@paulo.mongohq.com:10062/TedTest");
    DB db = new MongoClient(uri).getDB("TedTest");

    Jongo jongo = new Jongo(db);
    MongoCollection chipper = jongo.getCollection("chipper");

    chipper.save(chipEntry);

    Iterable<ChipEntry> all = chipper.find().as(ChipEntry.class);
    System.out.println(Joiner.on(", ").join(all));

    chipper.remove();
  }
}
