package bgu.spl.mics;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The {@link MessageBusImpl class is the implementation of the MessageBus interface.
 * Write your implementation here!
 * Only private fields and methods can be added to this class.
 */
public class MessageBusImpl implements MessageBus {


	private ConcurrentHashMap<Class<? extends Event>, LinkedBlockingQueue <MicroService>> mapEvent;
	private ConcurrentHashMap<Class<? extends Broadcast>, LinkedBlockingQueue <MicroService>> mapBroadcast;
	//private ArrayBlockingQueue <? extends Event> eventsQ;
	private ConcurrentHashMap<Class <MicroService>, LinkedBlockingQueue<Pair<MicroService,LinkedBlockingQueue<Message>>>> UltraDataBase ;
    private class SingletoneHolder{
	public MessageBusImpl instance=new MessageBusImpl();
}
	public static MessageBusImpl getInstance() {

		return new MessageBusImpl();
	}


	@Override
	public <T> void subscribeEvent(Class<? extends Event<T>> type, MicroService m) {
		// TODO Auto-generated method stub

			if (mapEvent.contains(type))
			{
				mapEvent.get(type).add(m);
			}
			else
			{
				LinkedBlockingQueue<MicroService> q = new LinkedBlockingQueue();
				q.add(m);
				mapEvent.put(type, q);
			}


	}

	@Override
	public void subscribeBroadcast(Class<? extends Broadcast> type, MicroService m) {

		if (mapBroadcast.contains(type))
		{
			mapBroadcast.get(type).add(m);
		}
		else
		{
			LinkedBlockingQueue<MicroService> q2 = new LinkedBlockingQueue();
			q2.add(m);
			mapBroadcast.put(type, q2);
			return;
		}


	}

	@Override
	public <T> void complete(Event<T> e, T result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendBroadcast(Broadcast b) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public <T> Future<T> sendEvent(Event<T> e) {

		return null;
	}

	@Override
	public void register(MicroService m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregister(MicroService m) {
		// TODO Auto-generated method stub

	}

	@Override
	public Message awaitMessage(MicroService m) throws InterruptedException {
		for (int i = 0; i<eventsQ.size(); i++)
		{
           mapEvent.get(eventsQ.)
		}
		return null;
	}
}