package com.softgroup.common.datamapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.softgroup.common.datamapper.support.ModelA;
import com.softgroup.common.datamapper.support.ModelB;
import com.softgroup.common.datamapper.support.ModelWithEnum;
import com.softgroup.common.exceptions.MapperException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

/**
 * @author odin
 * @since 15.02.17.
 */
public class MapperTest {

	@Test
	public void testNullArgs() {
		final JacksonDataMapper mapper = new JacksonDataMapper();

		assertThat(mapper.dataToString(null), is("null"));
		assertThat(mapper.objectToString(null), is("null"));
		assertThat(mapper.convert(null, ModelA.class), nullValue());

	}

	@Test
	public void testMap() {
		final JacksonDataMapper mapper = new JacksonDataMapper();

		String str = "{\"name\":\"hello\"}";
		ModelA ma = mapper.mapData(str, ModelA.class);
		assertThat(ma.getName(), is("hello"));
		assertThat(mapper.dataToString(ma), is(str));

		Map<String, Object> map = new HashMap<>();
		map.put("name", "hello world");

		ma = mapper.convert(map, ModelA.class);
		assertThat(ma.getName(), is("hello world"));

		ma = mapper.mapData(str, new TypeReference<ModelA>() {});
		assertThat(ma.getName(), is("hello"));
		assertThat(mapper.dataToString(ma), is(str));

		str = "{\"id\":\"1q2w3e\",\"list\":[{\"name\":\"asd\"},{\"name\":\"zxc\"}]}";
		ModelB<?> mb = mapper.mapData(str, ModelB.class);
		assertThat(mb.getId(), is("1q2w3e"));
		assertThat(mb.getList(), notNullValue());
		assertThat(mb.getList().size(), is(2));
		assertThat(mb.getList().get(0), is(instanceOf(Map.class)));
		ma = mapper.convert((Map<String, Object>) mb.getList().get(0), ModelA.class);
		assertThat(ma.getName(), is("asd"));

		Object oMap = mapper.convertToMap(mb);
		assertThat(oMap, notNullValue());
		assertThat(oMap , is(instanceOf(Map.class)));
		map = (Map<String, Object>) oMap;
		assertThat(map.get("id"), is("1q2w3e"));

		assertThat(mapper.convertToMap(null), nullValue());
	}

	@Test(expected = MapperException.class)
	public void testConvertEx() {
		new JacksonDataMapper().convert(new HashMap<>(), (Class)null);
	}

	@Test(expected = MapperException.class)
	public void testMapDataStringEx() {
		new JacksonDataMapper().mapData((String) null, ModelA.class);
	}

	@Test(expected = MapperException.class)
	public void testMapDataBytesEx() {
		new JacksonDataMapper().mapData((byte[]) null, ModelA.class);
	}

	@Test(expected = MapperException.class)
	public void testMapDataTypeRefEx() {
		new JacksonDataMapper().mapData(null, new TypeReference<ModelA>() {});
	}

	@Test(expected = MapperException.class)
	public void testConvertToMapEx() {
		List<String> list = new ArrayList<>();
		list.add("q");
		list.add("w");
		new JacksonDataMapper().convertToMap(list);
	}

	@Test
	public void testWithEnum() {
		final JacksonDataMapper mapper = new JacksonDataMapper();

		String str = "{\"name\":\"hello\",\"type\":1}";
		ModelWithEnum me = mapper.mapData(str, ModelWithEnum.class);
		assertThat(me.getName(), is("hello"));
		assertThat(me.getType(), is(ModelWithEnum.ModelType.MODEL_X));
		assertThat(mapper.dataToString(me), is(str));

		str = "{\"name\":\"hello\",\"type\":2}";
		me = mapper.mapData(str, ModelWithEnum.class);
		assertThat(me.getName(), is("hello"));
		assertThat(me.getType(), is(ModelWithEnum.ModelType.MODEL_Y));
		assertThat(mapper.dataToString(me), is(str));

	}

	@Test(expected = MapperException.class)
	public void testWithWrongEnumValue() {
		final JacksonDataMapper mapper = new JacksonDataMapper();
		String str = "{\"name\":\"hello\",\"type\":\"model_z\"}";
		ModelWithEnum me = mapper.mapData(str, ModelWithEnum.class);
	}

	@Test
	public void testWithNoEnumValue() {
		final JacksonDataMapper mapper = new JacksonDataMapper();
		String str = "{\"name\":\"hello\"}";
		ModelWithEnum me = mapper.mapData(str, ModelWithEnum.class);
		assertThat(me.getName(), is("hello"));
		assertThat(me.getType(), nullValue());
		assertThat(mapper.dataToString(me), is(str));

	}

}

