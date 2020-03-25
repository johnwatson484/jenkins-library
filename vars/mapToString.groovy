def String[] mapToString(Map map) {
  def output = [];
  for (item in map) {
      if (item.value instanceof String) {
          output.add("${item.key} = \"${item.value}\"");
      } else if (item.value instanceof Map) {
          output.add("${item.key} = {\n\t${mapToString(item.value).join("\n\t")}\n}");
      } else {
          output.add("${item.key} = ${item.value}");
      }
  }
  return output;
}
