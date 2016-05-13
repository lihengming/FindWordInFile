def path = 'C:\\Users\\admin\\Desktop\\spring-framework-word.txt'
findWordInTxtFile(new File(path))

void findWordInTxtFile(File file) {
    if (!file.exists())
        throw new RuntimeException('你输入的文件不存在，请检查您的文件路径！')
    def List<String> list = new ArrayList();
    file.eachLine {
        def strings = it.split('\\s')
        strings.each {
            if (it.matches('[a-z]+') && !list.contains(it)) {
                println new Date().timeString + '发现单词：' + it
                list.add(it)
            }

        }
    }
    def wordListFile = new File(file.getParentFile().getPath() + File.separator + 'word-list.txt');
    wordListFile.setText(list.toString().substring(1, list.toString().size() - 1));
    println '查找完毕,共发现' + list.size() + '个单词,已写入' + wordListFile + '文件内！'
}

