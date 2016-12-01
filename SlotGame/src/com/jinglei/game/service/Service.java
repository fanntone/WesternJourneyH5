package com.jinglei.game.service;

import java.util.Iterator;
import java.util.Map;

import com.jinglei.game.manage.CycleCostUnit;
import com.jinglei.game.manage.UtilTimeManage;

import io.netty.util.internal.chmv8.ConcurrentHashMapV8;


/*
 *	ConcurrentLinkedQueue
 *
 *      ConcurrentLinkedQueue使用方法非常簡單，但是使用前建議先有JAVA容器的基本觀念。
 *       ConcurrentLinkedQueue物件使用方法如下：
 *
 *        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
 *       queue.offer("TEST1");
 *       queue.offer("TEST2");
 *       String msg = queue.poll();
 *       System.out.println(msg);
 *
 *    這裡的觀念和其他JAVA容器一樣，可以指定容器內的物件型態，以上例而言，我們首先宣告了一個ConcurrentLinkedQueue物件，並指定內容物的型態是String。接下來，我們用queue.offer("TEST1")及queue.offer("TEST2")將字串"TEST1"及"TEST2"放到Queue裡面，接著使用poll()方法就可以將Queue裡面的物件取出，並且如果我們在宣告Queue時有指定內容物型態，取出的物件自然就會是該型態。上例的最後一行我們將msg印出，你會發現印出的是較先被放進Queue的"TEST1"。
 *    執行上例時會發現，當我們使用poll()方法將物件從Queue裡面取出，這個物件同時也從Queue裡面被移除了。如果你不想在取出物件的同時將其移除，只要將poll()改為使用peek()即可，並且也可以使用remove()方法將其移除，如下：
 *
 *      // 這兩行程式執行的結果會相當於String msg = queue.poll();
 *       String msg = queue.peek();
 *       queue.remove(msg);
 *       除了基本的存取物件方法，ConcurrentLinkedQueue也提供了取得物件數量或判斷某一個物件是否存在Queue中的方法，如下：
 *
 *      queue.size()
 *      queue.contains("TEST1")
 *************************************************************************************************
 *   創建一個最初為空的 ConcurrentLinkedQueue。
 *	 ConcurrentLinkedQueue()
 *	  創建一個最初包含給定 collection 元素的 ConcurrentLinkedQueue，按照此 collection 迭代器的遍歷順序來添加元素。
 *   ConcurrentLinkedQueue(Collection<? extends E> c)
 *   將指定元素插入此隊列的尾部。
 *   boolean add(E e)
 *  如果此隊列包含指定元素，則返回 true。
 *  boolean contains(Object o)
 *  如果此隊列不包含任何元素，則返回 true。
 *  boolean isEmpty()
 *  返回在此隊列元素上以恰當順序進行迭代的迭代器。
 *  Iterator<E> iterator()
 *  將指定元素插入此隊列的尾部。
 *  boolean offer(E e)
 *  獲取但不移除此隊列的頭；如果此隊列為空，則返回 null。
 *  E peek()
 *  獲取並移除此隊列的頭，如果此隊列為空，則返回 null。
 *  E poll()
 *  從隊列中移除指定元素的單個實例（如果存在）。
 *  boolean remove(Object o)
 *  返回此隊列中的元素數量。
 *  int size()
 *  返回以恰當順序包含此隊列所有元素的數組。
 *  Object[] toArray()
 * 返回以恰當順序包含此隊列所有元素的數組；返回數組的運行時類型是指定數組的運行時類型。
 * <T> T[] toArray(T[] a)
 */

public abstract class Service {
	
	public Service() {
		this.nextExecutionTime = CalculateNextExecutionTime();	
		
		if ( this.mapAttachment == null ) {
			this.mapAttachment = new ConcurrentHashMapV8<String, Object>(64);
		}
	}	
	
	/*
	 * 
	 * public ConcurrentHashMap(int initialCapacity,
	 *                        	float loadFactor,
	 *                        	int concurrencyLevel)創建一個帶有指定初始容量、加載因子和並發級別的新的空映射。
	 *
	 *			參數：
	 *				initialCapacity - 初始容量。該實現執行內部大小調整，以容納這些元素。
	 *				loadFactor - 加載因子閾值，用來控制重新調整大小。在每bin 中的平均元素數大於此閾值時，可能要重新調整大小。
	 *				concurrencyLevel - 當前更新線程的估計數。該實現將執行內部大小調整，以盡量容納這些線程。
	 *			拋出：
	 *				IllegalArgumentException - 如果初始容量為負，或者加載因子或concurrencyLevel 為非正。
	 */
	private ConcurrentHashMapV8<String, Object> mapAttachment = new ConcurrentHashMapV8<String, Object>(32);
	
	/******************************************************************************
	 * 可以針對同一個 Service 放入 Attachment.
	 * @param key_name String key 的名稱.
	 * @param value_obj 型別為 T 的 value 物件.
	 *****************************************************************************/
	public <T> boolean put(String key_name, T value_obj) 
	{
		System.out.println(String.format("[%s] put in  key:%s value:%s", this.getServiceName(),key_name,value_obj));
		if (key_name==null || key_name.equals("") || value_obj==null) {
			return false;
		}
			
		if (mapAttachment.containsKey(key_name)) {
			mapAttachment.remove(key_name);
		}

		mapAttachment.put(key_name, value_obj);
		
		this.getServiceName();
		return true;
	}
	
	/******************************************************************************
	 * 可以針對同一個 Service 設定 Attachment.
	 * @param key_name String key 的名稱.
	 * @param value_obj 型別為 T 的 value 物件.
	 *****************************************************************************/
	public <T> boolean setAttachment(ConcurrentHashMapV8<String, Object> attachment) 
	{
		if ( attachment != null  && !attachment.isEmpty()) {
			mapAttachment.clear();
			mapAttachment = attachment;
			return true;			
		}
		
		return false;
	}
	
	/******************************************************************************
	 * 可以針對同一個 Service 清除 Attachment  內容
	 *****************************************************************************/
	public <T> boolean clearAttachment() 
	{
		mapAttachment.clear();
		return true;
	}
	
	/******************************************************************************
	 * 可以針對同一個 Service 取出 Attachment.
	 * @param key_name String key 的名稱.
	 * @param value_obj 型別為 T 的 value 物件.
	 *****************************************************************************/	
	public <T> ConcurrentHashMapV8<String, Object> getAttachment() 
	{
		if ( mapAttachment != null  && !mapAttachment.isEmpty()) {
			return mapAttachment;			
		}
		
		return null;
	}
	
	/******************************************************************************
	 * 取回放在 Attachment 中的東西, 取出之後, 內容物並不會消失!!
	 * @param key_name String key 的名稱.
	 * @return 型別為 T 的 value 物件. 如果沒有取到, 會傳回 null.
	 *****************************************************************************/
	@SuppressWarnings({ "unchecked" })
	public <T> T get(String key_name,boolean[] check_code) 
	{
		if (key_name==null || key_name.equals("")) {
			check_code[0] = false;		
			return null;
		}
			
		Object key = mapAttachment.get(key_name);
		
		if (key == null){
			check_code[0] = false;	
			return null;
		}
		
		check_code[0] = true;			
		return (T) key;
	}
	
	public void printOutTheCurrentMap(){
		
		Iterator<?> it = mapAttachment.entrySet().iterator();
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(String.format("service[%s] key:[%s] value:[%s]",this.getServiceName(),pair.getKey() ,pair.getValue()));			 
		}
	}
	
	/*
	 *   取得  Service Instance
	 */
	public abstract Service newInstance();	
	
	/*
	 *   取得  Service Instance
	 */
	public abstract String getServiceName();	

	/*
	 * 執行  Service 
	 */
	public abstract int  Execute();
	
	private Long nextExecutionTime = (long)10*60;
	/*
	 * 下次執行時間
	 */
	public abstract long CalculateNextExecutionTime();
	
	public boolean isExecute() {
		if ( nextExecutionTime < 1 ) {
			return true;
		}
		
		if ( UtilTimeManage.getCurrentTimeToService() >= nextExecutionTime) {
			return true;
		}
		
		return false;
	}
	
	public Long getNextExecutionTime() {
		return nextExecutionTime;
	}
	
	public abstract void BuildService();	
	
	/*
	 * 效能  調整
	 */
	private CycleCostUnit   cycleCost   =  null;
	
	public CycleCostUnit  getCycleCost() {
		return cycleCost;
	}
	
	public CycleCostUnit  setCycleCost(CycleCostUnit unit) {
		if ( unit != null ) {
			cycleCost = unit;
			return cycleCost;
		}
		
		return null;
	}
	
	public void CycleCostBegin() {
		cycleCost = UtilTimeManage.CycleCostBegin(getServiceName());
	}
	
	public void CycleCostEnded() {
		if ( cycleCost != null ) {
			UtilTimeManage.CycleCostEnded(cycleCost);
		}
	}
}
