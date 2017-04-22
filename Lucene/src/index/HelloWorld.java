package index;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * ��Lucene3.6.2����ϵ�С���01��_HelloWord
 * @see ����ֻ���õ�һ��lucene-core-3.6.2.jar
 * @see Lucene����:http://lucene.apache.org
 * @see Lucene����:http://archive.apache.org/dist/lucene/java/
 * @see Lucene�ĵ�:http://wiki.apache.org/lucene-java/
 * @see -------------------------------------------------------------------------------------------------------------
 * @see 1)����ȫ����������,�������������ִʡ��������������
 * @see 2)���洢�ͱ�����,�����������ĸ���
 * @see -------------------------------------------------------------------------------------------------------------
 * @see ��Ĵ洢ѡ��
 * @see Field.Store.YES--��Ѹ����е����ݴ洢���ļ���,��������ı��Ļ�ԭ
 * @see Field.Store.NO---��ʾ�����е����ݲ��洢���ļ���,����������,�������޷���ȫ��ԭ(doc.get("##"))
 * @see -------------------------------------------------------------------------------------------------------------
 * @see �������ѡ��
 * @see Field.Index.ANALYZED----------------���зִʺ�����,�����ڱ��⡢���ݵ�
 * @see Field.Index.NOT_ANALYZED------------�������������ִ�(�����֤�š�������ID��),�����ھ�ȷ����
 * @see Field.Index.ANALYZED_NOT_NORMS------���зִʵ��ǲ��洢norms��Ϣ,���norms�а����˴���������ʱ���Ȩֵ����Ϣ
 * @see Field.Index.NOT_ANALYZED_NOT_NORMS--�������зִ�Ҳ���洢norms��Ϣ
 * @see Field.Index.NO----------------------����������
 * @see norms:�����ݱ�����������,���漰�����������,����������һЩ���ֹ����,����NORMS�оʹ洢����Щ�������Ϣ
 * @see ------------------------------------------------------------------------------------------------------------- 
 * @see ��ѡ�����ʵ��
 * @see Field.Store   Field.Index              ��ֵ
 * @see       YES     NOT_ANALYZED_NOT_NORMS   ��ʶ�����������ļ�����,�绰����,���֤��,����,����
 * @see       YES     ANALYZED                 �ĵ������ժҪ
 * @see        NO     ANALYZED                 �ĵ�����
 * @see        NO     NOT_ANALYZED             ���عؼ���
 * @see       YES     NO                       �ĵ�����,���ݿ�������������������
 * @see -------------------------------------------------------------------------------------------------------------
 * @create Jun 29, 2012 4:20:19 PM
 * @author ����<http://blog.csdn.net/jadyer>
 */
public class HelloWorld {
	private static final String PATH_OF_FILE = "f:/s/";   //�������ļ���Ŀ¼
	private static final String PATH_OF_INDEX = "f:/index/"; //��������ļ���Ŀ¼
	
	/**
	 * ��������
	 * @see ---------------------------------------------------------------------------------------------------------
	 * @see 1������Directory-----------------ָ�������������λ��
	 * @see 2������IndexWriter---------------ͨ��IndexWriterд����
	 * @see 3������Document����---------------�����������п�����һ���ı�or���ݿ��е�һ�ű�
	 * @see 4��ΪDocument���Field------------�൱��Document�ı��⡢��С�����ݡ�·���ȵ�,�������������ݿ����ÿ����¼���ֶεĹ�ϵ
	 * @see 5��ͨ��IndexWriter����ĵ���������
	 * @see 6���ر�IndexWriter----------------����IndexWriter֮��,����ر�֮
	 * @see ---------------------------------------------------------------------------------------------------------
	 * @see _0.fdt��_0.fdx�ļ�--�����������洢������(Field.Store.YES�����µ�)
	 * @see _0.fnm�ļ�----------������ѡ�������(��new Field(name, value)�е�name)
	 * @see _0.frq�ļ�----------��¼��ͬ���ļ�(���ѯ�Ĺؼ���)���ֵĴ���,�������������ֺ������
	 * @see _0.nrm�ļ�----------�洢һЩ������Ϣ
	 * @see _0.prx�ļ�----------��¼ƫ����
	 * @see _0.tii��_0.tis�ļ�--�洢�������������������Ϣ
	 * @see segments_1�ļ�------���Ƕ��ļ�,Lucene���Ȼᵽ���ļ��в�����Ӧ��������Ϣ
	 * @see ---------------------------------------------------------------------------------------------------------
	 */
	public void createIndex(){
		Directory directory = null;
		IndexWriter writer = null;
		Document doc = null;
		try{
			//FSDirectory����ݵ�ǰ�����л�����һ������Ļ���File��Directory(�����ڴ��д���������new RAMDirectory())
			//��������Ӳ����"D:/OS_Folder/Desktop/luceneDemo/index01/"�ļ����д�������
			directory = FSDirectory.open(new File(PATH_OF_INDEX));
			//����Lucene2.9֮��,�������ĸ�ʽ�Ͳ����ټ���Lucene�����а汾��,�����ڴ�������ǰ,Ҫָ������ƥ���Lucene�汾��
			//����ͨ��IndexWriterConfig()���췽����Version.LUCENE_36����ֵָ��������ƥ��İ汾��,��ʹ����Lucene�ı�׼�ִ���,36Ӧ�þ���36����˼
			writer = new IndexWriter(directory, new IndexWriterConfig(Version.LUCENE_36, new StandardAnalyzer(Version.LUCENE_36)));
			for(File file : new File(PATH_OF_FILE).listFiles()){
				doc = new Document();
				//��������ӵ���������,��Ϊ���ĵ��洢��Ϣ,����������ʱʹ��(�����д��,��Ĭ��ΪField.Store.NO��Field.Index.ANALYZED)
				//����������content������Ҳ�洢��Ӳ����,�Ǿ���Ҫ�Ȱ�fileת�����ַ���,Ȼ����"fileName"�Ĵ洢��ʽ�ӵ�Field��
				//���ǿ�����commons-io-2.3.jar�ṩ��FileUtils.readFileToString(file),���Ǻܷ���Ĺ��߰�,������������������д�κε�IO������
				//doc.add(new Field("content", FileUtils.readFileToString(file), Field.Store.YES, Field.Index.ANALYZED));
				doc.add(new Field("content", new FileReader(file)));
				//Field.Store.YES-----------�����ǽ��ļ���ȫ���洢��Ӳ����
				//Field.Index.NOT_ANALYZED--�����ǲ����ļ������зִ�
				doc.add(new Field("fileName", file.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED));
				doc.add(new Field("filePath", file.getAbsolutePath(), Field.Store.YES, Field.Index.NOT_ANALYZED));
				//ͨ��IndexWriter����ĵ���������
				writer.addDocument(doc);
			}
		}catch(Exception e){
			System.out.println("���������Ĺ����������쳣,��ջ�켣����");
			e.printStackTrace();
		}finally{
			if(null != writer){
				try {
					writer.close(); //IndexWriter������֮��һ��Ҫ�ر�
				} catch (IOException ce) {
					System.out.println("�ر�IndexWriterʱ�����쳣,��ջ�켣����");
					ce.printStackTrace();
				} 
			}
		}
	}
	
	
	/**
	 * �����ļ�
	 * @see 1������Directory
	 * @see 2������IndexReader
	 * @see 3������IndexReader����IndexSearcher
	 * @see 4������������Query
	 * @see 5������searcher����������TopDocs
	 * @see 6������TopDocs��ȡScoreDoc����
	 * @see 7������searcher��ScoreDoc�����ȡ�����Document����
	 * @see 8������Document�����ȡ��Ҫ��ֵ
	 * @see 9���ر�IndexReader
	 */
	public void searchFile(){
		IndexReader reader = null;
		try{
			reader = IndexReader.open(FSDirectory.open(new File(PATH_OF_INDEX)));
			IndexSearcher searcher = new IndexSearcher(reader);
			//��������Parser������Query,����ʱ��ָ����"�����İ汾,Ĭ����������,�ִ���"....�������ָ���Ǵ�������ʱField������
			QueryParser parser = new QueryParser(Version.LUCENE_36, "content", new StandardAnalyzer(Version.LUCENE_36));
			Query query = parser.parse("������ȷ�Ŵ������");       //ָ��==>������Ϊcontent(����һ�д���ָ����"content")�а���"java"���ĵ�
			TopDocs tds = searcher.search(query, 10); //�ڶ�������ָ����������ʾ������,���鵽5������ʾΪ5��,�鵽15����ֻ��ʾ10��
			ScoreDoc[] sds = tds.scoreDocs;           //TopDocs�д�ŵĲ��������ǵ��ĵ�,�����ĵ���ScoreDoc����
			System.out.println(sds.length);
			for(ScoreDoc sd : sds){                   //ScoreDoc�����൱��ÿ���ĵ���ID��,���ǾͿ���ͨ��ScoreDoc�������ĵ�
				Document doc = searcher.doc(sd.doc);  //sd.doc�õ������ĵ������
				System.out.println(doc.get("fileName") + "[" + doc.get("filePath") + "]"); //������ĵ����洢����Ϣ
			}
		}catch(Exception e){
			System.out.println("�����ļ��Ĺ����������쳣,��ջ�켣����");
			e.printStackTrace();
		}finally{
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("�ر�IndexReaderʱ�����쳣,��ջ�켣����");
					e.printStackTrace();
				}
			}
		}
	}
}