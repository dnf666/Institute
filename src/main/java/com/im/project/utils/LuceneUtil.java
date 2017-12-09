package com.im.project.utils;

import com.im.project.model.Article;
import com.im.project.service.ArticleService;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LuceneUtil {
    private Directory dir = null;

@Resource
    ArticleService articleService;
    /**
     * 获取IndexWriter实例
     *
     * @return
     * @throws Exception
     */
    private IndexWriter getWriter() throws Exception {
       try{
        dir = FSDirectory.open(Paths.get("index"));
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(dir, iwc);
        return writer;
         }catch (Exception e){
            //System.out.println("null");
        }
        return null;
    }

    /**
     * 添加索引
     *
     * @param
     */
    public void addIndex() throws Exception {
        IndexWriter writer = getWriter();
        Document doc = new Document();
    List<Article> list=articleService.selectAllArticle();
        Iterator<Article> iterator=list.iterator();
        while(iterator.hasNext())
        {
            Article article=iterator.next();
            doc.add(new TextField("id",String.valueOf(article.getId()),Field.Store.YES));
            doc.add(new TextField("title", article.getTitle(), Field.Store.YES));
            doc.add(new TextField("author", article.getAuthor(), Field.Store.YES));
            doc.add(new TextField("keyword", article.getKeyword(), Field.Store.YES));
            doc.add(new TextField("summary", article.getSummary(), Field.Store.YES));
            doc.add(new TextField("date", article.getDate(), Field.Store.YES));
        }
        writer.addDocument(doc);

    }
//
///**
// * 更新博客索引
// * @param user
// * @throws Exception
// */
//public void updateIndex(User user)throws Exception {
//        IndexWriter writer=getWriter();
//        Document doc=new Document();
//        doc.add(new StringField("id", String.valueOf(user.getUserId()), Field.Store.YES));
//        doc.add(new TextField("username", user.getUsername(), Field.Store.YES));
//        doc.add(new TextField("description",user.getDescription(), Field.Store.YES));
//        writer.updateDocument(new Term("id", String.valueOf(user.getUserId())), doc);
//        writer.close();
//        }

///**
// * 删除指定博客的索引
// * @param userId
// * @throws Exception
// */
//public void deleteIndex(String userId)throws Exception {
//        IndexWriter writer=getWriter();
//        writer.deleteDocuments(new Term("id", userId));
//        writer.forceMergeDeletes(); // 强制删除
//        writer.commit();
//        writer.close();
//        }

    /**
     * 查询用户
     *
     * @param q 查询关键字
     * @return
     * @throws Exception
     */
    public List<Article> searchBlog(String q, HttpServletRequest request) throws Exception {
        /**
         * 注意的是查询索引的位置得是存放索引的位置，不然会找不到。
         */
//        String path = request.getContextPath();
//        //System.out.println("path="+path);
//        String basePath = request.getScheme() + "://"
//                + request.getServerName() + ":" + request.getServerPort()
//                + path + "/";
        List<Article> articleList = null;
        try {
            FileSystem system = FileSystems.getDefault();
            dir = FSDirectory.open(system.getPath("../index"));
            IndexReader reader = DirectoryReader.open(dir);
            IndexSearcher is = new IndexSearcher(reader);
            BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
            SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
            QueryParser parser = new QueryParser("keyword", analyzer);
            Query query = parser.parse(q);

            booleanQuery.add(query, BooleanClause.Occur.SHOULD);
            TopDocs hits = is.search(booleanQuery.build(), 100);
            QueryScorer scorer = new QueryScorer(query);
            Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
            /**
             * 这里可以根据自己的需要来自定义查找关键字高亮时的样式。
             */
            SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color='red'>", "</font></b>");
            Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
            highlighter.setTextFragmenter(fragmenter);
            articleList = new LinkedList<Article>();
            for (ScoreDoc scoreDoc : hits.scoreDocs) {
                Document doc = is.doc(scoreDoc.doc);
                Article article = new Article();
                String title = doc.get("title");
                article.setAuthor(doc.get("author"));
                article.setDate(doc.get("date"));
                article.setId(Integer.parseInt(doc.get("id")));
                article.setSummary(doc.get("summary"));
                article.setKeyword(doc.get("keyword"));
                if (title != null) {
                    TokenStream tokenStream = analyzer.tokenStream("title", new StringReader(title));
                    String hightLightTile = highlighter.getBestFragment(tokenStream, title);
                    article.setTitle(hightLightTile);
                    articleList.add(article);
                }
            }
            return articleList;
        } catch (Exception e) {
            //System.out.println("111111111111");
            e.printStackTrace();
        }
        return null;
        }
    }